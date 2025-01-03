import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-category-details',
  imports: [NgFor, NgIf],
  templateUrl: './category-details.component.html',
  styleUrl: './category-details.component.css'
})
export class CategoryDetailsComponent implements OnInit{
  categoryId: string | null = null;
  categoryName: string = '';
  categoryDescription: string = '';
  elements: any[] = [];
  baseUrl: string = 'http://localhost:8082/api';

  constructor(private route: ActivatedRoute, protected router: Router) {}

  ngOnInit(): void {
    this.categoryId = this.route.snapshot.paramMap.get('id');
    if (this.categoryId) {
      this.fetchCategoryDetails();
      this.fetchElements();
    }
  }

  fetchElements(): void {
    fetch(`${this.baseUrl}/elements/section/${this.categoryId}`).then((response) => {
      return response.json();
    }).then((response) =>{
      this.elements = response;
    });
  }

  fetchCategoryDetails(): void {
    fetch(`${this.baseUrl}/sections/${this.categoryId}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error(`Nie udało się pobrać szczegółów kategorii + ${this.categoryId}`);
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

  showModal: boolean = false;
  elementIdToDelete: string | null = null;

  openConfirmationModal(id: string): void {
    this.showModal = true;
    this.elementIdToDelete = id;
  }

  cancelDeletion(): void {
    this.showModal = false;
    this.elementIdToDelete = null;
  }

  confirmDeletion(): void {
    if (this.elementIdToDelete) {
      fetch(`${this.baseUrl}/elements/${this.elementIdToDelete}`, {
        method: 'DELETE',
      })
        .then((response) => {
          if (response.ok) {
            this.elements = this.elements.filter(
              (element) => element.id !== this.elementIdToDelete
            );
            console.log('Sekcja została pomyślnie usunięta');
          } else {
            console.error('Błąd podczas usuwania sekcji');
          }
        })
        .catch((error) => console.error('Wystąpił błąd:', error))
        .finally(() => {
          this.showModal = false;
          this.elementIdToDelete = null;
        });
    }
  }

  editElement(id: string): void {
    this.router.navigate([`/categories/${this.categoryId}/elements/${id}/edit`]);
  }

  addElement(): void {
    this.router.navigate([`/categories/${this.categoryId}/elements/add`]);
  }

  detailsView(id: string): void {
    this.router.navigate([`categories/${this.categoryId}/elements/${id}/details`]);
  }
}
