package jth.com.thetrive.domain.usecase

import jth.com.thetrive.data.repository.SampleRepository
import jth.com.thetrive.domain.model.LocalSample

class GetLocalSampleUseCase(private val repository: SampleRepository) {
    suspend operator fun invoke(
    ): List<LocalSample> {
        val result: MutableList<LocalSample> = mutableListOf()
        val response = repository.getLocalSample()

        response.forEach {
            result.add(LocalSample(it.id, it.name))
        }

        return result
    }
}