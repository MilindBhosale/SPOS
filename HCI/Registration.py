import tkinter as tk
from tkinter import messagebox
from tkinter import ttk

def register_student():
    name = entry_name.get()
    roll_number = entry_roll.get()
    grade = grade_var.get()
    #selected_courses = [course for course, var in zip(courses, course_var) if var.get()]

    # Assuming you want to display the entered information
    messagebox.showinfo("Registration Successful") #f"Name: {name}\nRoll Number: {roll_number}\nGrade: {grade}\nCourses: {', '.join(selected_courses)}")

root = tk.Tk()
root.title("Student Registration")
root.configure(bg="#E7F5E8")

label_name = tk.Label(root, text="Name:", font=('Arial', 15), bg="#E7F5E8")
label_name.place(x=70, y=50)
entry_name = tk.Entry(root)
entry_name.place(x=280, y=55)

label_roll = tk.Label(root, text="Roll Number:", font=('Arial', 15), bg="#E7F5E8")
label_roll.place(x=70, y=100)
entry_roll = tk.Entry(root)
entry_roll.place(x=280, y=105)

label_grade = tk.Label(root, text="Grade:", font=('Arial', 15), bg="#E7F5E8")
label_grade.place(x=70, y=150)
grade_var = tk.StringVar(root)
grade_var.set("A")  # Default value
grade_dropdown = ttk.Combobox(root, textvariable=grade_var, values=["A", "B", "C"])
grade_dropdown.place(x=280, y=155)

label_courses = tk.Label(root, text="Courses:", font=('Arial', 15), bg="#E7F5E8")
label_courses.place(x=70, y=200)

course_var = [tk.BooleanVar() for _ in range(3)]
courses = ["Math", "Science", "English"]

for i in range(len(courses)):
    tk.Checkbutton(root, text=courses[i], variable=course_var[i], bg="#E7F5E8").place(x=280, y=205 + i*30)

register_button = tk.Button(root, text="Register", command=register_student)
register_button.place(x=250, y=350)

root.mainloop()