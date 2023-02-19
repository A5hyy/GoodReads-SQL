import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { MasterComponent } from './components/master/master.component';
import { DetailsComponent } from './components/details/details.component';
import { BookService } from './services/book.service';

//Create a constant to assign the routes
const appRoutes: Routes = [
  // assign the Master Component Route
  {path: '', component: MasterComponent },
  // assign the details component route (link with server get mapping)
  {path: 'book/:bookId', component: DetailsComponent},
  // anything else, route back to '/' (home)
  {path: '**', redirectTo: '/', pathMatch: 'full'}
]

@NgModule({
  declarations: [
    AppComponent,
    MasterComponent,
    DetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [BookService],
  bootstrap: [AppComponent]
})
export class AppModule { }
