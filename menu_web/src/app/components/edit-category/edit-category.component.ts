import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-category',
  imports: [FormsModule],
  templateUrl: './edit-category.component.html',
  styleUrl: './edit-category.component.css'
})
export class EditCategoryComponent implements OnInit{
  categoryId: string | null = null;
  categoryName: string = '';
  categoryDescription: string = '';
  baseUrl: string = 'http://localhost:8082/api';

  constructor(private route: ActivatedRoute, protected router: Router) {}

  ngOnInit(): void {
    this.categoryId = this.route.snapshot.paramMap.get('id');
    if (this.categoryId) {
      this.fetchCategoryDetails();
    }
  }

  fetchCategoryDetails(): void {
    fetch(`${this.baseUrl}/sections/${this.categoryId}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error(`Nie udało się pobrać szczegółów kategorii`);
        }
        return response.json();
      })
      .then((category) => {
        this.categoryName = category.name;
        this.categoryDescription = category.description;
      })
      .catch((error) => {
        console.error('Błąd podczas pobierania kategorii:', error);
      });
  }

  updateCategory(): void {
    fetch(`${this.baseUrl}/sections/${this.categoryId}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ name: this.categoryName, description: this.categoryDescription }),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error('Nie udało się zaktualizować kategorii');
        }
        return response.json();
      })
      .then((updatedCategory) => {
        console.log('Zaktualizowano kategorię:', updatedCategory);
        this.router.navigate(['/categories']);
      })
      .catch((error) => {
        console.error('Błąd podczas aktualizacji kategorii:', error);
      });
  }
}
