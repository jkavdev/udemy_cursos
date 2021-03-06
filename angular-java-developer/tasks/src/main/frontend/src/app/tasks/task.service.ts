import {EventEmitter, Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

import {Task} from "./task.model";

@Injectable()
export class TaskService {

    taskUrl = '/api/tasks';

    onTaskAdded = new EventEmitter<Task>();

    constructor(private http: HttpClient) {
    }

    getTasks(): Observable<Task[]> {
        return this.http.get<Task[]>(this.taskUrl);
    }

    saveTask(task: Task, checked: boolean): Observable<Task> {
        task.completed = checked;
        return this.http.post<Task>(`${this.taskUrl}/save`, task);
    }

    addTask(task: Task): Observable<Task> {
        return this.http.post<Task>(`${this.taskUrl}/save`, task);
    }

}
