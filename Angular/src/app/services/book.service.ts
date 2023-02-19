import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { Book, BookSummary } from '../models';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private httpClient: HttpClient) { }

  // Return a promise of an array of books(BookSummary[]) from models.ts
  getBooks(): Promise<BookSummary[]>{
    return firstValueFrom(
      this.httpClient.get<BookSummary[]>('/api/books'))
  }

  // Pass in the bookId
  // Return a promise of a book(Book) from models.ts
  getBookById(bookId: string): Promise<Book>{
    return firstValueFrom(
      this.httpClient.get<Book>(`/api/book/${bookId}`)
    )
  }
}

                               