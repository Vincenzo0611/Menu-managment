import {Routes } from '@angular/router';
import { CategoriesListComponent } from './components/categories-list/categories-list.component';
import { AddCategoryComponent } from './components/add-category/add-category.component';
import { EditCategoryComponent } from './components/edit-category/edit-category.component';
import { CategoryDetailsComponent } from './components/category-details/category-details.component';
import { AddElementComponent } from './components/add-element/add-element.component';
import { EditElementComponent } from './components/edit-element/edit-element.component';
import { ElementDetailsComponent } from './components/element-details/element-details.component';

export const routes: Routes = [
  { 
    path: '', 
    redirectTo: 'categories', 
    pathMatch: 'full' 
  },
  { 
    path: 'categories', 
    pathMatch: 'full' ,
    component: CategoriesListComponent 
  },
  { path: 'categories/add', component: AddCategoryComponent },
  { path: 'categories/:id/edit', component: EditCategoryComponent },
  { path: 'categories/:id/elements', component: CategoryDetailsComponent },
  { path: 'categories/:id/elements/add', component: AddElementComponent },
  { path: 'categories/:id/elements/:elementId/edit', component: EditElementComponent },
  { path: 'categories/:id/elements/:elementId/details', component: ElementDetailsComponent },
];

