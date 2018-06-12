import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StreamsCreateComponent } from './streams-create.component';

describe('StreamsCreateComponent', () => {
  let component: StreamsCreateComponent;
  let fixture: ComponentFixture<StreamsCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StreamsCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StreamsCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
