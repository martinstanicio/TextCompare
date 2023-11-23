package com.curso.android.app.practica.textcompare

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.textcompare.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val value = viewModel.result.value?.result
        assertEquals(true, value)
    }

    @Test
    fun mainViewModel_TestTruthyComparison() = runTest {
        launch {
            viewModel.makeTextComparison("test string", "test string")
        }
        advanceUntilIdle()
        val value = viewModel.result.value?.result
        assertEquals(true, value)
    }

    @Test
    fun mainViewModel_TestFalsyComparison() = runTest {
        launch {
            viewModel.makeTextComparison("test string", "a different test string")
        }
        advanceUntilIdle()
        val value = viewModel.result.value?.result
        assertEquals(false, value)
    }
}
