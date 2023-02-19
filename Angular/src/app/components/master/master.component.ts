import { Component, OnInit } from '@angular/core';
import { BookSummary } from 'src/app/models';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-master',
  templateUrl: './master.component.html',
  styleUrls: ['./master.component.css']
})
export class MasterComponent implements OnInit{

  books: BookSummary[] = []

  //Inject in the BookService
  constructor (private bookService: BookService) { }

  ngOnInit(): void {
    this.bookService.getBooks()
    .then(books => {
      this.books = books
      console.info('>>>> books:', this.books)
    })
    .catch(error => {
      console.error('>>>> error:', error)
    })
  }

}
