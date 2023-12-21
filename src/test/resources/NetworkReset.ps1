
Disable-NetAdapter -Name "Ethernet0" -Confirm:$false

Enable-NetAdapter -Name "Ethernet0" -Confirm:$false