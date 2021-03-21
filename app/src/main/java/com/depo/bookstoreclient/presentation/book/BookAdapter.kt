package com.depo.bookstoreclient.presentation.book

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.depo.bookstoreclient.R
import com.depo.bookstoreclient.data.model.book.Book
import com.depo.bookstoreclient.databinding.ListItemBookBinding

class BookAdapter() : RecyclerView.Adapter<MyViewHolder>() {
    private val bookList = ArrayList<Book>()

    fun setList(books: List<Book>) {
        bookList.clear()
        bookList.addAll(books)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBookBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item_book,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(bookList[position])

    }

    override fun getItemCount(): Int {
        return bookList.size
    }

}

class MyViewHolder(val binding: ListItemBookBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(book: Book) {
        binding.textViewBook1New.text = book.title
        binding.customLayoutLinearNew.setOnClickListener {
           /* val sharedIntent =  Intent(binding.root.context, BookActivity::class.java)
            sharedIntent.putExtra("title", book.title)
            sharedIntent.putExtra("image", book.thumbnail)
            sharedIntent.putExtra("author", book.bookAuthor)
            sharedIntent.putExtra("pageNumber", book.pageNumber)
            sharedIntent.putExtra("description", book.description)
            sharedIntent.putExtra("bookUrl", book.bookURL)
            sharedIntent.putExtra("bookID", book.bookId)
            sharedIntent.putExtra("category", book.category)
            binding.root.context.startActivity(sharedIntent)*/
        }
        val bookThumbnailUrl = book.thumbnail
        Glide.with(binding.imageViewBook1New.context)
            .load(bookThumbnailUrl)
            .apply(RequestOptions().override(150, 200))
            .into(binding.imageViewBook1New)
    }
}