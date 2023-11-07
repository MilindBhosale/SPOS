import tkinter as tk
from tkinter import messagebox

def login_clicked():
    if username.get() == "admin" and password.get() == "password":
        messagebox.showinfo("Login Successful", "Welcome, admin!")
    else:
        messagebox.showerror("Login Failed", "Invalid username or password")

root=tk.Tk()
root.title("Login Page")
root.configure(bg="#E7F5E8")

lb=tk.Label(root, text="Login here...." , fg="blue", font=('Arial',25))
lb.place(x=650, y=100)

lb1=tk.Label(root, text="Enter user name:-", fg="black" , font=('Arial', 15))
lb1.place(x=70, y=250)

username=tk.Entry()
username.place(x=280, y=255)

lb2=tk.Label(root, text="Enter Password:-", fg="black", font=("Arial",15))
lb2.place(x=70, y=300)

password=tk.Entry(show="*")
password.place(x=280, y=305)

login_button = tk.Button(root, text="Login", command=login_clicked)
login_button.place(x=250, y=350)

root.mainloop()