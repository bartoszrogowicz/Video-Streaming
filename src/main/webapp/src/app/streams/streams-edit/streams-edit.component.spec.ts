import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StreamsEditComponent } from './streams-edit.component';

describe('StreamsEditComponent', () => {
  let component: StreamsEditComponent;
  let fixture: ComponentFixture<StreamsEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StreamsEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StreamsEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
