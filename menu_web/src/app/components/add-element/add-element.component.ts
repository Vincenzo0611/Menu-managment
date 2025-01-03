import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-element',
  imports: [FormsModule],
  templateUrl: './add-element.component.html',
  styleUrl: './add-element.component.css'
})
export class AddElementComponent {
  elementName: string = '';
  elementPrice: number = 0;
  categoryId: string | null = null;

  private baseUrl = 'http://localhost:8082/api';

  constructor(private route: ActivatedRoute, protected router: Router) {}

  ngOnInit(): void {
    this.categoryId = this.route.snapshot.paramMap.get('id');
  }


  addElement(): void {
    fetch(`${this.baseUrl}/elements/section/addId/${this.categoryId}`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ name: this.elementName, price: this.elementPrice }),
    })
      .then((response) => {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error('Nie udało się dodać elementu');
        }
      })
      .then((newCategory) => {
        console.log('Dodano element:', newCategory);
        this.router.navigate([`/categories/${this.categoryId}/elements`]);
      })
      .catch((error) => {
        console.error('Błąd podczas dodawania elementu:', error);
      });
  }

}
