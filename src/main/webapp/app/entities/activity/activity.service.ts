import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { SERVER_API_URL } from '../../app.constants';

import { Activity } from './activity.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class ActivityService {

    private resourceUrl = SERVER_API_URL + 'api/activities';

    constructor(private http: Http) { }

    create(activity: Activity): Observable<Activity> {
        const copy = this.convert(activity);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            return this.convertItemFromServer(jsonResponse);
        });
    }

    update(activity: Activity): Observable<Activity> {
        const copy = this.convert(activity);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            return this.convertItemFromServer(jsonResponse);
        });
    }

    find(id: number): Observable<Activity> {
        return this.http.get(`${this.resourceUrl}/${id}`).map((res: Response) => {
            const jsonResponse = res.json();
            return this.convertItemFromServer(jsonResponse);
        });
    }

    query(req?: any): Observable<ResponseWrapper> {
        const options = createRequestOption(req);
        return this.http.get(this.resourceUrl, options)
            .map((res: Response) => this.convertResponse(res));
    }

    delete(id: number): Observable<Response> {
        return this.http.delete(`${this.resourceUrl}/${id}`);
    }

    private convertResponse(res: Response): ResponseWrapper {
        const jsonResponse = res.json();
        const result = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            result.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return new ResponseWrapper(res.headers, result, res.status);
    }

    /**
     * Convert a returned JSON object to Activity.
     */
    private convertItemFromServer(json: any): Activity {
        const entity: Activity = Object.assign(new Activity(), json);
        return entity;
    }

    /**
     * Convert a Activity to a JSON which can be sent to the server.
     */
    private convert(activity: Activity): Activity {
        const copy: Activity = Object.assign({}, activity);
        return copy;
    }
}
