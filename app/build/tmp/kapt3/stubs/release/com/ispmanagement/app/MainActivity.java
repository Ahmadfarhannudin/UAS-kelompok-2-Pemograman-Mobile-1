package com.ispmanagement.app;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0006\u0010\u001b\u001a\u00020\u0012J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001f"}, d2 = {"Lcom/ispmanagement/app/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/ispmanagement/app/databinding/ActivityMainBinding;", "navController", "Landroidx/navigation/NavController;", "session", "Lcom/ispmanagement/app/data/SessionManager;", "topLevelDestinations", "", "", "<set-?>", "Lcom/ispmanagement/app/viewmodel/AppViewModel;", "viewModel", "getViewModel", "()Lcom/ispmanagement/app/viewmodel/AppViewModel;", "closeDrawer", "", "handleMenuClick", "", "item", "Landroid/view/MenuItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "refreshDrawerState", "syncMenuSelection", "destinationId", "arguments", "app_release"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.ispmanagement.app.databinding.ActivityMainBinding binding;
    private androidx.navigation.NavController navController;
    private com.ispmanagement.app.data.SessionManager session;
    private com.ispmanagement.app.viewmodel.AppViewModel viewModel;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<java.lang.Integer> topLevelDestinations = null;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ispmanagement.app.viewmodel.AppViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    public final void closeDrawer() {
    }
    
    public final void refreshDrawerState() {
    }
    
    private final void syncMenuSelection(int destinationId, android.os.Bundle arguments) {
    }
    
    private final boolean handleMenuClick(android.view.MenuItem item) {
        return false;
    }
}