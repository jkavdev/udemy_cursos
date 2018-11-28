import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

import {Task} from "./task.model";

@Injectable()
export class TaskService {

    taskUrl = '/api/tasks'

    constructor(private http: HttpClient) {
    }

    getTasks(): Observable<Task[]> {
        return this.http.get<Task[]>(this.taskUrl)
    }

}
