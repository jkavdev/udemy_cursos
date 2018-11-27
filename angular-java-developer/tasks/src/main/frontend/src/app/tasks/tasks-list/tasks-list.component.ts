import {Component, OnInit} from '@angular/core';

import {Task} from '../task.model';

@Component({
    selector: 'app-tasks-list',
    templateUrl: './tasks-list.component.html',
    styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {

    tasks: Task[] = []

    constructor() {
    }

    ngOnInit() {
        this.tasks.push(new Task(1, "Task1", true, "27/11/2018"));
        this.tasks.push(new Task(1, "Task1", false, "27/11/2018"));
        this.tasks.push(new Task(1, "Task1", false, "27/11/2018"));
    }

    onTaskChange($event, task: Task) {
        console.log('A tarefa mudou');
    }

    getDueDateLabel(task: Task) {
        return task.completed ? 'label-success' : 'label-primary';
    }
}
