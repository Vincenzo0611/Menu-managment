import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElementDetailsComponent } from './element-details.component';

describe('ElementDetailsComponent', () => {
  let component: ElementDetailsComponent;
  let fixture: ComponentFixture<ElementDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ElementDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ElementDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
