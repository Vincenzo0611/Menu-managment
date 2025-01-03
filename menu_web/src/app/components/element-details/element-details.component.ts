import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-element-details',
  imports: [],
  templateUrl: './element-details.component.html',
  styleUrl: './element-details.component.css'
})
export class ElementDetailsComponent implements OnInit{
  categoryId: string | null = null;
  elementId: string | null = null;
  categoryName: string = '';
  categoryDescription: string = '';
  elementName: string = '';
  elementPrice: number = 0;

  baseUrl: string = 'http://localhost:8082/api';


  constructor(private route: ActivatedRoute, protected router: Router) {}

  ngOnInit(): void {
    this.categoryId = this.route.snapshot.paramMap.get('id');
    this.elementId = this.route.snapshot.paramMap.get('elementId');
    if (this.categoryId) {
      this.fetchCategoryDetails();
      this.fetchElementDetails();
    }
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

  routeBack(): void{
    this.router.navigate([`/categories/${this.categoryId}/elements`]);
  }
}
