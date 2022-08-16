package com.aungbophyoe.space.runningapp.viewmodel

import androidx.lifecycle.ViewModel
import com.aungbophyoe.space.runningapp.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(val mainRepository: MainRepository) : ViewModel() {
}