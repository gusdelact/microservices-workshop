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

  error(t:string){
    this.add({'type': 'danger', 'text': t})
  }

  warn(t:string){
    this.add({'type': 'warning', 'text': t})
  }

  success(t:string){
    this.add({'type': 'success', 'text': t})
  }

  info(t:string){
    this.add({'type': 'info', 'text': t})
  }
}
