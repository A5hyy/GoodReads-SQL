import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Book } from 'src/app/models';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit{

    params$!: Subscription
    
    //From Model
    book!: Book

    constructor(private activatedRoute: ActivatedRoute, private bookService: BookService){}

  ngOnInit(): void {
    //subscribe to bookId
    this.params$ = this.activatedRoute.params.subscribe(
      // to get the bookId
      (params) => {
        const bookId = params['bookId']
        this.bookService.getBookById(bookId)
        .then(result => {
          //from params above = to name before =>
          this.book = result
          console.info('>>>> book:', this.book)
        })
        .catch(error => {
          console.error('>>>> error', error)
        })
      }
    )
  }

}
