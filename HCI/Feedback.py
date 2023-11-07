import tkinter as tk
from tkinter import messagebox

def submit_feedback():
    username_text = username.get().strip()
    feedback_text = feedback.get("1.0", tk.END).strip()
    selected_food = food_var.get()

    if username_text and feedback_text and selected_food:
        messagebox.showinfo("Feedback Submitted", "Thank you for your feedback!")
        # You can add code here to save the feedback to a file or database
    else:
        messagebox.showerror("Error", "Please fill out all fields.")

root = tk.Tk()
root.title("Feedback Form")
root.configure(bg="#E7F5E8")

# Heading
heading = tk.Label(root, text="Feedback Form", fg="blue", font=('Arial', 25))
heading.place(x=600, y=50)

# Username Label and Entry
username_label = tk.Label(root, text="Username:", fg="black", font=('Arial', 15))
username_label.place(x=70, y=150)

username = tk.Entry(root)
username.place(x=250, y=150)

# Feedback Label and Textbox
feedback_label = tk.Label(root, text="Your Feedback:", fg="black", font=('Arial', 15))
feedback_label.place(x=70, y=200)

feedback = tk.Text(root, height=5, width=50)
feedback.place(x=250, y=200)

# Food Dropdown
food_label = tk.Label(root, text="Select Food:", fg="black", font=('Arial', 15))
food_label.place(x=70, y=350)

food_options = ["Pizza", "Burger", "Pasta", "Salad"]
food_var = tk.StringVar(root)
food_var.set(food_options[0])

food_dropdown = tk.OptionMenu(root, food_var, *food_options)
food_dropdown.place(x=250, y=350)

# Submit Button
submit_button = tk.Button(root, text="Submit Feedback", command=submit_feedback)
submit_button.place(x=350, y=450)

root.mainloop()