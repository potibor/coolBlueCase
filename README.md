# coolBlueCase

## Architecture

- Single Activity
- MVVM Pattern
- Repository
- UseCase

**View:** Renders UI and delegates user actions to ViewModel

**ViewModel:** Can have simple UI logic but most of the time just gets the data from UseCase

**UseCase:** Contains all business rules and they written in the manner of single responsibility principle

**Repository:** Single source of data. Responsible to get data from one or more data sources

<img width="677" alt="architecture-diagram" src="https://user-images.githubusercontent.com/26321700/107923530-b0593500-6f82-11eb-99bb-312e149f1757.png">

## Tech Stack

#### Dependencies

- **[Navigation Component](https://developer.android.com/jetpack/androidx/releases/navigation):** Consistent navigation between views
- **[LiveData](https://developer.android.com/topic/libraries/architecture/livedata):** Lifecycle aware observable and data holder
- **[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel):** Holds UI data across configuration changes
- **[ViewBinding](https://developer.android.com/topic/libraries/view-binding):** Creating An instance of a binding class contains direct references to all views that have an ID in the corresponding layout.
- **[Coroutines](https://github.com/Kotlin/kotlinx.coroutines):** Asynchronous programming
- **[Glide](https://github.com/bumptech/glide):** Image loading and caching
- **[Hilt](https://github.com/googlecodelabs/android-hilt):** Dependency injector
- **[CoroutineTest](https://developer.android.com/codelabs/advanced-android-kotlin-training-testing-survey#0):** Unit Testing
