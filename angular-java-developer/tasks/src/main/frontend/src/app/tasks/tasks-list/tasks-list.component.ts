import {Component, OnInit} from '@angular/core';

import {Task} from '../task.model';
import {TaskService} from "../task.service";

@Component({
    selector: 'app-tasks-list',
    templateUrl: './tasks-list.component.html',
    styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {

    tasks: Task[] = []

    constructor(private taskService: TaskService) {
    }

    ngOnInit() {
        return this.taskService.getTasks()
            .subscribe(
                (task: any[]) => {
                    this.tasks = task
                },
                (error) => console.log(error)
            );
    }

    onTaskChange($event, task: Task) {
        console.log('A tarefa mudou');
    }

    getDueDateLabel(task: Task) {
        return task.completed ? 'label-success' : 'label-primary';
    }
}
