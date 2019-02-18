import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NotificationsService {

  notifications: Object[] = []

  constructor() { }


  close(n){
    this.notifications.splice(this.notifications.indexOf(n), 1);
  }

  add(n:Object){
    this.notifications.push(n)
    setTimeout(() => this.close(n) , 10000);
  }
}
