import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-element',
  imports: [FormsModule],
  templateUrl: './edit-element.component.html',
  styleUrl: './edit-element.component.css'
})
export class EditElementComponent implements OnInit{
  categoryId: string | null = null;
  elementId: string | null = null;
  elementName: string = '';
  elementPrice: number = 0;
  baseUrl: string = 'http://localhost:8082/api';

  constructor(private route: ActivatedRoute, protected router: Router) {}

  ngOnInit(): void {
    this.categoryId = this.route.snapshot.paramMap.get('id');
    this.elementId = this.route.snapshot.paramMap.get('elementId');
    if (this.elementId) {
      this.fetchElementDetails();
    }
  }

  fetchElementDetails(): void {
    fetch(`${this.baseUrl}/elements/${this.elementId}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error(`Nie udało się pobrać szczegółów elementu`);
        }
        return response.json();
      })
      .then((element) => {
        this.elementName = element.name;
        this.elementPrice = element.price;
      })
      .catch((error) => {
        console.error('Błąd podczas pobierania elementu:', error);
      });
  }

  updateElement(): void {
    fetch(`${this.baseUrl}/elements/${this.elementId}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ name: this.elementName, price: this.elementPrice }),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error('Nie udało się zaktualizować elementu');
        }
        return response.json();
      })
      .then((updatedElement) => {
        console.log('Zaktualizowano element:', updatedElement);
        this.router.navigate([`/categories/${this.categoryId}/elements`]);
      })
      .catch((error) => {
        console.error('Błąd podczas aktualizacji elementu:', error);
      });
  }

  routeBack(): void{
    this.router.navigate([`/categories/${this.categoryId}/elements`]);
  }
}
