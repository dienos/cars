package jth.com.thetrive.domain.usecase

import jth.com.thetrive.data.repository.SampleRepository
import jth.com.thetrive.domain.model.Sample

class GetSampleUseCase(private val repository: SampleRepository) {
    suspend operator fun invoke(
    ): List<Sample> {
        val result: MutableList<Sample> = mutableListOf()
        val response = repository.getSample()

        response.forEach {
            result.add(Sample(it.name))
        }

        return result
    }
}