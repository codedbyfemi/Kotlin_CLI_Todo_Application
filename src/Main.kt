fun main() {
    val tasks = mutableListOf<Todo>();
    var taskId = 1;

    while (true) {
        println("\nTo-Do Manager")
        println("1. Add Task")
        println("2. View Tasks")
        println("3. Mark Task as Done")
        println("4. Delete Task")
        println("5. Exit")

        when (readln().toInt()) {
            1 -> {
                println("Enter Task Description: ")
                val task = readlnOrNull() ?: ""
                tasks.add(Todo(taskId, task))
                println("Task $taskId is added")
                taskId++
            }

            2 -> {
                println("\nYour Tasks:")
                tasks.forEach {
                    val status = if (it.isDone) "[✓]" else "[ ]"
                    println("${it.id}. $status ${it.description}")
                }
            }

            3 -> {
                print("Enter task ID to mark as done: ")
                val id = readlnOrNull()?.toIntOrNull()
                val task = tasks.find { it.id == id }
                if (task != null) {
                    task.isDone = true
                    println("Task marked as done.")
                } else println("Task not found.")
            }

            4 -> {
                print("Enter task ID to delete: ")
                val id = readlnOrNull()?.toIntOrNull()
                val task = tasks.find { it.id == id }
                if (task != null) {
                    tasks.removeAt(tasks.indexOf(task))
                } else {
                    println("Task not found.")
                }
            }

            5 -> {
                println("Exiting...")
                break
            }

            else -> println("Invalid choice.")
        }
    }
}