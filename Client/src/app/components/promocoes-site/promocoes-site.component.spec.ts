import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PromocoesSiteComponent } from './promocoes-site.component';

describe('PromocoesSiteComponent', () => {
  let component: PromocoesSiteComponent;
  let fixture: ComponentFixture<PromocoesSiteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PromocoesSiteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PromocoesSiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
