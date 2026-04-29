import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.example.a29api.MyCommentsItem
import android.view.LayoutInflater
import com.example.a29api.databinding.ItemCommentBinding

class CommentsAdapter(private val list: ArrayList<MyCommentsItem>) :
    RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemCommentBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCommentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
            holder.binding.apply {
                tvName.text = item.name
                tvEmail.text = item.email
                tvBody.text = item.body
                tvId.text = "ID: ${item.id}"
                tvPostId.text = "PostID: ${item.postId}"

        }



    }

    override fun getItemCount(): Int = list.size
}