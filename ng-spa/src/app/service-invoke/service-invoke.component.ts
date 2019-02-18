import { Component, OnInit } from '@angular/core';

import { MicroservicioBaseService } from '../services/microservicio-base.service'

@Component({
  selector: 'app-service-invoke',
  templateUrl: './service-invoke.component.html',
  styleUrls: ['./service-invoke.component.css']
})
export class ServiceInvokeComponent implements OnInit {

  serviceResponses: string[] = []

  constructor(private microServicioBaseService: MicroservicioBaseService) { }

  ngOnInit() {
  }

  saludo(){
    this.microServicioBaseService.saludo().subscribe(data => {
      this.serviceResponses.unshift(data);
      console.log(data)
      
    })
  }

  mensaje(){
    this.microServicioBaseService.mensaje().subscribe(data => {
      this.serviceResponses.unshift(data);
      console.log(data)
    })
  }

}
