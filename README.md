# ScreenStateView

Android library to manage different screen states like loading, error and empty state.

[![Kotlin](https://img.shields.io/badge/Kotlin-1.2.71-blue.svg?style=flat-square)](http://kotlinlang.org)
[![GitHub (pre-)release](https://img.shields.io/github/release/mastro993/screenstateview/all.svg?style=flat-square)
](./../../releases)

### Implementation

``` Groovy
// Module level build.gradle
dependencies {
    // Replace version with release version, e.g. 1.0.0-alpha, -SNAPSHOT
    implementation 'com.ehzlab:screenstateview:[VERSION]'
}
```

### Usage

``` XML
<com.ehzlab.screenstateview.ScreenStateLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    app:empty_layout="@layout/layout_state_empty"
    app:error_layout="@layout/layout_state_error"
    app:loading_layout="@layout/layout_state_loading"
    android:layout_width="match_parent"                            
    android:layout_height="match_parent"
    android:id="@+id/ss_layout">

    <!-- Content -->

</com.ehzlab.screenstateview.ScreenStateLayout>
```
Then in the code

``` Kotlin

ss_layout.state = ScreenState.Loading // Set the state to Loading to display loading animation
ss_layout.state = ScreenState.Empty // Set the state to Empty to display empty layout
ss_layout.state = ScreenState.Error // Sets the state to Error to display error layout
ss_layout.state = ScreenState.Show // Displays the normal view content

```

In the above example I used my custom empty, loading and error states layout. If the attributes are left empty the library loads default layouts (very ugly, but better than nothing).
