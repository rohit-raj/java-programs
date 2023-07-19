import itertools
import threading
import zipfile

class BruteForceThread(threading.Thread):
    def __init__(self, file_path, charset, min_length, max_length):
        threading.Thread.__init__(self)
        self.file_path = file_path
        self.charset = charset
        self.min_length = min_length
        self.max_length = max_length

    def run(self):
        for length in range(self.min_length, self.max_length + 1):
            for combination in self.generate_combinations(length):
                password = ''.join(combination)
                if self.try_password(password):
                    print(f"Password found: {password}")
                    return

    def generate_combinations(self, length):
        for combination in itertools.product(self.charset, repeat=length):
            yield combination

    def try_password(self, password):
        try:
            with zipfile.ZipFile(self.file_path) as zipf:
                zipf.open(pwd=password.encode())
                return True
        except zipfile.BadZipFile:
            pass
        except RuntimeError as e:
            if str(e) == "Bad password for file":
                pass
#             else:
#                 print(f"Error: {str(e)}")
#         except Exception as e:
#             print(f"Error: {password}")
        return False

def main():
    file_path = "./testZipFile.zip"  # Update with the file path you want to open
#     charset = "ahijklnoprst_#$012589"
    charset = "adebcfg"
    min_length = 3
    max_length = 4

    threads = []
    for i in range(1):  # Number of threads (change as desired)
        str_len = min_length+i
        thread = BruteForceThread(file_path, charset, str_len, str_len)
        thread.start()
        threads.append(thread)

    for thread in threads:
        thread.join()

    print("Password not found.")

if __name__ == "__main__":
    main()
