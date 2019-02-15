import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceInvokeComponent } from './service-invoke.component';

describe('ServiceInvokeComponent', () => {
  let component: ServiceInvokeComponent;
  let fixture: ComponentFixture<ServiceInvokeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceInvokeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceInvokeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
