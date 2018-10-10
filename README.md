# ScreenStateView

Android library to manage different screen states like loading, error and empty state.


![CircleCI (all branches)](https://img.shields.io/circleci/project/github/mastro993/ScreenStateView.svg)
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

Attributes `empty_layout`, `error_layout` and `loading_layout` are the custom layout that ares showed in the different view states.

You can change the view state like in the code below:

``` Kotlin

ss_layout.state = ScreenState.Loading // Sets the view state to Loading state
ss_layout.state = ScreenState.Empty // Sets the view state to Empty state
ss_layout.state = ScreenState.Error // Sets the view state to Error state
ss_layout.state = ScreenState.Show // Displays the normal view content

```

In the above example I used my custom empty, loading and error states layout. If the attributes are left empty the library loads default layouts (very ugly, but better than nothing).
