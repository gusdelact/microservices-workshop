import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


const serviceUrlBase = 'https://zuulsvr-v4-0.127.0.0.1.nip.io/api/' 

const saludo: string = serviceUrlBase + 'microservicio-base/microservicio/v3/saludo'
const mensaje: string = serviceUrlBase + 'microservicio-base/microservicio/v3/mensaje'
const postEvent: string = serviceUrlBase + 'microservicio-base/microservicio/event'
const lastEventLogEntries: string = serviceUrlBase + 'e/event-log/last-entry'
const eventsCounter: string = serviceUrlBase + 'c/event-counter/number-events'

@Injectable({
  providedIn: 'root'
})
export class MicroservicioBaseService {

  constructor(private http: HttpClient) { }

  saludo(){
    return this.http.get(saludo,{responseType: 'text'})
  }

  mensaje(){
    return this.http.get(mensaje,{responseType: 'text'})
  }

  postEvent(tweetText: string){
    return this.http.post(postEvent,{text: tweetText})
  }

  lastEventLogs(){
    return this.http.get(lastEventLogEntries)
  }

  eventsCounter(){
    return this.http.get(eventsCounter)
  }
  
}
