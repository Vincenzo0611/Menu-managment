import { Component } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-categories-list',
  imports: [NgFor, NgIf],
  templateUrl: './categories-list.component.html',
  styleUrl: './categories-list.component.css'
})
export class CategoriesListComponent {
  categories: any[] = [];
  private baseUrl = 'http://localhost:8082/api';
  
  constructor(protected router: Router) {
    fetch(`${this.baseUrl}/sections`).then((response) => {
      return response.json();
    }).then((response) =>{
      this.categories = response;
    });
  }

  showModal: boolean = false;
  categoryIdToDelete: string | null = null;

  openConfirmationModal(id: string): void {
    this.showModal = true;
    this.categoryIdToDelete = id;
  }

  cancelDeletion(): void {
    this.showModal = false;
    this.categoryIdToDelete = null;
  }

  confirmDeletion(): void {
    if (this.categoryIdToDelete) {
      fetch(`${this.baseUrl}/sections/${this.categoryIdToDelete}`, {
        method: 'DELETE',
      })
        .then((response) => {
          if (response.ok) {
            this.categories = this.categories.filter(
              (category) => category.id !== this.categoryIdToDelete
            );
            console.log('Sekcja została pomyślnie usunięta');
          } else {
            console.error('Błąd podczas usuwania sekcji');
          }
        })
        .catch((error) => console.error('Wystąpił błąd:', error))
        .finally(() => {
          this.showModal = false;
          this.categoryIdToDelete = null;
        });
    }
  }

  editCategory(id: string): void {
    this.router.navigate([`/categories/${id}/edit`]);
  }

  elementsView(id: string): void {
    this.router.navigate([`/categories/${id}/elements`]);
  }

}
