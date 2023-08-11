package ru.netology.diplomchina.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.netology.diplomchina.R
import ru.netology.diplomchina.databinding.FragmentCreateEditPostBinding
import ru.netology.diplomchina.db.PostEntity
import ru.netology.diplomchina.viewModel.PostViewModel

class CreateEditPostFragment : Fragment() {
    private val viewModel: PostViewModel by viewModels(
        ownerProducer = ::requireParentFragment
    )

    private lateinit var binding: FragmentCreateEditPostBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateEditPostBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)


        return binding.root
    }


    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_create_edit_post_menu, menu)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_add_post -> {
                val content = binding.eTPostContent.text.toString()
                viewModel.savePost(PostEntity(content = content))
                findNavController().popBackStack()
                true
            }
            else -> false
        }
    }

}