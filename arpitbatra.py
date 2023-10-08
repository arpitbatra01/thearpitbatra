import json
import os

NOTES_FILE = "notes.json"

def load_notes():
if os.path.exists(NOTES_FILE):
with open(NOTES_FILE, "r") as file:
return json.load(file)
else:
return []

def save_notes(notes):
with open(NOTES_FILE, "w") as file:
json.dump(notes, file)

def list_notes():
notes = load_notes()
if notes:
print("Your Notes:")
for index, note in enumerate(notes, start=1):
print(f"{index}. {note}")
else:
print("No notes found.")

def add_note(note):
notes = load_notes()
notes.append(note)
save_notes(notes)
print("Note added successfully.")

def delete_note(index):
notes = load_notes()
if 1 <= index <= len(notes):
delete_note = notes.pop(index - 1)
save_notes(notes)
print(f"Deleted note: {deleted_note}")
else:
print("Invalid note index.")

def main():
while True:
print("\nOptions:")
print("1. List notes")
print("2. Add a note")
print("3. Delete a note")
print("4. Quit")

choice = input("Enter an option: ")

if choice == "1":
list_notes()
elif choice == "2":
note = input("Enter your note: ")
add_note(note)
elif choice == "3":
index = int(input("Enter the index of the note to delete: "))
delete_note(index)
elif choice == "4":
print("Goodbye!")
break
else:
print("Invalid option. Please try again.")

if __name__ == "__main__":
main()
# program created by arpitbatra01
