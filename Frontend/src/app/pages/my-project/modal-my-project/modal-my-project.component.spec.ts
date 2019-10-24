import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalMyProjectComponent } from './modal-my-project.component';

describe('ModalMyProjectComponent', () => {
  let component: ModalMyProjectComponent;
  let fixture: ComponentFixture<ModalMyProjectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModalMyProjectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalMyProjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
