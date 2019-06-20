import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PromocaoEdicaoComponent } from './promocao-edicao.component';

describe('PromocaoEdicaoComponent', () => {
  let component: PromocaoEdicaoComponent;
  let fixture: ComponentFixture<PromocaoEdicaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PromocaoEdicaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PromocaoEdicaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
