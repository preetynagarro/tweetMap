package com.template.tweet.di.module

import com.template.tweet.presentation.view.MainViewModel
import com.template.core.viewmodel.SharedViewModel
import com.template.core.viewmodel.ToolbarPropertyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

/****
 * DI module which provides all the viewmodel instances

 *****/
object ViewModelModule {
    fun load() {
        loadKoinModules(module {
            viewModel {
                MainViewModel()
            }

            viewModel {
                ToolbarPropertyViewModel()
            }

            viewModel {
                SharedViewModel()
            }

        })
    }
}