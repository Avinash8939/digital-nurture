
class Node {
    Task task;
    Node next;

    Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskLinkedList {
    private Node head;

    public TaskLinkedList() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTaskById(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null; 
    }

    public void traverseTasks() {
        Node current = head;
        System.out.println("Task List:");
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public boolean deleteTaskById(int taskId) {
        if (head == null) {
            return false; 
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId() == taskId) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false; 
    }

    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task(1, "Design", "Pending"));
        taskList.addTask(new Task(2, "Development", "In Progress"));
        taskList.addTask(new Task(3, "Testing", "Not Started"));

        taskList.traverseTasks();

        Task task = taskList.searchTaskById(2);
        if (task != null) {
            System.out.println("Task found: " + task);
        } else {
            System.out.println("Task not found.");
        }

        boolean deleted = taskList.deleteTaskById(2);
        if (deleted) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found for deletion.");
        }

        taskList.traverseTasks();
    }
}

 class Task {
    private int taskId;
    private String taskName;
    private String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
