import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


const serviceUrlBase = 'https://zuulsvr-v4-0.127.0.0.1.nip.io/api/' 

const saludo: string = serviceUrlBase + 'microservicio-base/microservicio/v3/saludo'
const mensaje: string = serviceUrlBase + 'microservicio-base/microservicio/v3/mensaje'
 
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
  
}
