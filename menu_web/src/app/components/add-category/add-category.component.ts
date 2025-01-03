import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-category',
  imports: [FormsModule],
  templateUrl: './add-category.component.html',
  styleUrl: './add-category.component.css'
})
export class AddCategoryComponent {
  categoryName: string = '';
  categoryDescription	: string = '';
  private baseUrl = 'http://localhost:8082/api';

  constructor(protected router: Router) {}

  addCategory(): void {
    fetch(`${this.baseUrl}/sections`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ name: this.categoryName, description: this.categoryDescription }),
    })
      .then((response) => {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error('Nie udało się dodać kategorii');
        }
      })
      .then((newCategory) => {
        console.log('Dodano kategorię:', newCategory);
        this.router.navigate(['/categories']); // Przekierowanie do listy kategorii
      })
      .catch((error) => {
        console.error('Błąd podczas dodawania kategorii:', error);
      });
  }
}
