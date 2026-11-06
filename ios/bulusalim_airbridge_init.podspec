Pod::Spec.new do |s|
  s.name             = 'bulusalim_airbridge_init'
  s.version          = '1.0.0'
  s.summary          = 'Tracks Airbridge deep links without editing AppDelegate.'
  s.homepage         = 'https://github.com/crucialpartnership/bulusalim_airbridge_init'
  s.license          = { :type => 'Proprietary', :text => 'Private use only.' }
  s.author           = { 'Bulusalim' => 'dev@bulusalim.app' }
  s.source           = { :path => '.' }
  s.source_files     = 'Classes/**/*'
  s.dependency 'Flutter'
  s.dependency 'airbridge_flutter_sdk'
  s.platform         = :ios, '12.0'
  s.swift_version    = '5.0'
  s.pod_target_xcconfig = { 'DEFINES_MODULE' => 'YES' }
end
