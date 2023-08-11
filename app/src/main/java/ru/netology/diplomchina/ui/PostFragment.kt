package ru.netology.diplomchina.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.netology.diplomchina.R
import ru.netology.diplomchina.adapter.PostAdapter
import ru.netology.diplomchina.databinding.FragmentPostBinding
import ru.netology.diplomchina.viewModel.PostViewModel

class PostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding =  FragmentPostBinding.inflate(inflater, container, false)
        val viewModel : PostViewModel by viewModels()

        setHasOptionsMenu(true)

        val adapter = PostAdapter()
        binding.rVPosts.adapter = adapter

        viewModel.postList.observe(viewLifecycleOwner){ postData ->
            adapter.submitList(postData)
        }


        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_post_menu, menu)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_add_post -> {
                findNavController().navigate(R.id.action_nav_posts_fragment_to_createEditPostFragment)
                true
            }
            else -> false
        }
    }
}