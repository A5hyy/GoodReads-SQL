// Model for the summary of book
export interface BookSummary {
    bookId: string,
    title: string
}

//Model for the whole book
export interface Book {
    bookId: string,
    title: string,
    authors: string,
    description: string,
    rating: number
    
}