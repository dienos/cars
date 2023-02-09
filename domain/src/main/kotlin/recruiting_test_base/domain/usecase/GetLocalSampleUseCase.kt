package recruiting_test_base.domain.usecase

import recruiting_test_base.data.repository.SampleRepository
import recruiting_test_base.domain.model.LocalSample

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